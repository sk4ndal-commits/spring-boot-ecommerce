package com.luv2code.ecommerce.dto

import lombok.Data

@Data
data class PurchaseResponse(val orderTrackingNumber: String? = null)