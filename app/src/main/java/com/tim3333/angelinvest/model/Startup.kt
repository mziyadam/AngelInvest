package com.example.affirmation.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Startup(val backImgUrl: String?=null, val description: String?=null, val filled: Int?=0, val imgUrl: String?=null, val location: String?=null, val maximum: Int?=0, val minimum: Int?=0, val name: String?=null, val stage : String?=null, val target: Int?=0   )

