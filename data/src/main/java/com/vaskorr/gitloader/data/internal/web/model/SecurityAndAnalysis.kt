package com.vaskorr.gitloader.data.internal.web.model

import com.google.gson.annotations.SerializedName
import com.vaskorr.gitloader.data.internal.web.model.AdvancedSecurity
import com.vaskorr.gitloader.data.internal.web.model.SecretScanning
import com.vaskorr.gitloader.data.internal.web.model.SecretScanningPushProtection


internal data class SecurityAndAnalysis (

    @SerializedName("advanced_security"               ) var advancedSecurity             : AdvancedSecurity?             = AdvancedSecurity(),
    @SerializedName("secret_scanning"                 ) var secretScanning               : SecretScanning?               = SecretScanning(),
    @SerializedName("secret_scanning_push_protection" ) var secretScanningPushProtection : SecretScanningPushProtection? = SecretScanningPushProtection()

)