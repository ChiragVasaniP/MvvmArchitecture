package com.example.mvvmarchitecture.data

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
data class UserData (
    @Id
    var userId:Long=0,
    var userName:String="testUser",
    var userEmail:String="abc@gmail.com",
    var userImage:String?=null
)