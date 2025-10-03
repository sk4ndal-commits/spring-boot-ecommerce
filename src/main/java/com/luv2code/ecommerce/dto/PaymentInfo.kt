package com.luv2code.ecommerce.dto

import lombok.Data

@Data
class PaymentInfo
{
    var receiptEmail: String? = null
    var amount: Integer? = null
    var currency: String? = null
}
