package com.example.simple.beagle

import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.setup.BeagleConfig
import br.com.zup.beagle.android.setup.Cache
import br.com.zup.beagle.android.setup.Environment
import com.example.simple.constants.BASE_URL

@BeagleComponent
class AppBeagleConfig : BeagleConfig {
    override val isLoggingEnabled: Boolean = true
    override val baseUrl: String get() = BASE_URL
    override val environment: Environment get() = Environment.DEBUG
    override val cache: Cache = Cache(
            enabled = true,
            maxAge = 300,
            memoryMaximumCapacity = 15
    )
}