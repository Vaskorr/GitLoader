package com.vaskorr.data.internal.web.model

import com.google.gson.annotations.SerializedName


internal data class SecurityAndAnalysis (

  @SerializedName("advanced_security"               ) var advancedSecurity             : AdvancedSecurity?             = AdvancedSecurity(),
  @SerializedName("secret_scanning"                 ) var secretScanning               : SecretScanning?               = SecretScanning(),
  @SerializedName("secret_scanning_push_protection" ) var secretScanningPushProtection : SecretScanningPushProtection? = SecretScanningPushProtection()

)