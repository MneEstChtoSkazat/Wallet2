package com.example.wallet.data

data class WalletItem(
    val symbol: String,
    val name: String,
    val amount: String
)

/**
 * Метка пункта обмена на карте.
 * fx и fy — положение метки как доля ширины и высоты экрана (0..1).
 * В практической работе 4 вместо них появятся настоящие координаты.
 */
data class ExchangePoint(
    val fx: Float,
    val fy: Float
)

/** Статические данные для практической работы 2: ни базы, ни сети пока нет. */
object SampleData {
    const val TOTAL = "Всего: 152 340 ₽"

    val wallet = listOf(
        WalletItem(symbol = "Ξ", name = "Ethereum", amount = "1.893 Руб."),
        WalletItem(symbol = "B", name = "Bitcoin", amount = "12000 Руб."),
        WalletItem(symbol = "¥", name = "Юань", amount = "4000 Руб."),
        WalletItem(symbol = "Ð", name = "Doggy Coin", amount = "200.000 Руб."),
        WalletItem(symbol = "$", name = "Доллар", amount = "1000 Руб.")
    )

    val exchangePoints = listOf(
        ExchangePoint(fx = 0.265f, fy = 0.456f),
        ExchangePoint(fx = 0.755f, fy = 0.415f),
        ExchangePoint(fx = 0.230f, fy = 0.623f)
    )

    val mainCurrencies = listOf("RUB", "USD", "EUR")
}
