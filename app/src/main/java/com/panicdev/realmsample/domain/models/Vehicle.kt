package com.panicdev.realmsample.domain.models

data class Vehicle(
    var nopol: String = "",
    var id: Long = 0,
    var model: String = "",
    var color: String = "",
    var frameNumber: String = "",
    var machineNumber: String = "",
    var year: String = "",
    var leasing: String = "",
    var branch: String = "",
    var debtorName: String = "",
    var remainingDebt: String = "",
    var date: String = ""
)