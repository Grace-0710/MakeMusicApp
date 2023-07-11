import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.LibraryExtension
import com.makemusic.apps.convention.AppConfig
import com.makemusic.apps.convention.configureFlavors
import com.makemusic.apps.convention.configureKotlinAndroid
import com.makemusic.apps.convention.configurePrintApksTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = AppConfig.targetSdkVersion
                configureFlavors(this)
            }

            extensions.configure<LibraryAndroidComponentsExtension> {
                configurePrintApksTask(this)
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            configurations.configureEach {
                resolutionStrategy {
//                    force(libs.findLibrary("junit4").get())
                }
            }

            dependencies {
                add("implementation", libs.findLibrary("timber").get())
            }
        }
    }
}
