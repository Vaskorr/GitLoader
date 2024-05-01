package com.vaskorr.data.internal.web.model

import com.google.gson.annotations.SerializedName


internal data class Permissions (

  @SerializedName("admin" ) var admin : Boolean? = null,
  @SerializedName("push"  ) var push  : Boolean? = null,
  @SerializedName("pull"  ) var pull  : Boolean? = null

)