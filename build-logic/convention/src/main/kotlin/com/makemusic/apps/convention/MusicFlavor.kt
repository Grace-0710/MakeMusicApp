package com.makemusic.apps.convention

import com.android.build.api.dsl.*
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import java.util.Properties

@Suppress("EnumNaming")
enum class FlavorDimension {
    contentType
}

@Suppress("EnumNaming")
enum class MusicFlavor(val dimension: FlavorDimension, val applicationIdSuffix: String? = null) {
    dev(FlavorDimension.contentType, applicationIdSuffix = ".dev"),
    stage(FlavorDimension.contentType, applicationIdSuffix = ".stage"),
    prod(FlavorDimension.contentType, applicationIdSuffix = "")
}

fun Project.configureFlavors(
    commonExtension: CommonExtension<*, *, *, *>,
    flavorConfigurationBlock: ProductFlavor.(flavor: MusicFlavor) -> Unit = {}
) {
    commonExtension.apply {
        flavorDimensions += FlavorDimension.contentType.name
        productFlavors {
            MusicFlavor.values().forEach {
                create(it.name) {
                    initializeProperties(this )
                    dimension = it.dimension.name
                    flavorConfigurationBlock(this, it)
                    if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (it.applicationIdSuffix != null) {
                            this.applicationIdSuffix = it.applicationIdSuffix
                        }
                    }

                }
            }
        }
    }
}

fun Project.initializeProperties(flavor: ProductFlavor
) {
    val properties = Properties().apply {
        load(project.rootProject.file("./config/${flavor.name}.properties").inputStream())
    }

    properties.keys.forEach { key ->
        (key as String)
        flavor.buildConfigField("String",
            key,
            "\"${properties.getProperty(key) as String}\"")
    }
}
