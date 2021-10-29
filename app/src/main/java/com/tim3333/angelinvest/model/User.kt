package com.tim3333.angelinvest.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(var id: String?=null, var email: String?=null, var name:String?=null, var total:Int?=null, val assets:MutableMap<String,Int>?=null, val favourite:MutableMap<String,String>?=null) {
}