package com.example.latihankonsep

object QuotesData {
    var quotes = listOf<String>(
        "The greatest glory in living lies not in never falling, but in rising every time we fall. \n\n-Nelson Mandela",
        "The way to get started is to quit talking and begin doing. \n\n-Walt Disney",
        "Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking. \n\n-Steve Jobs",
        "If life were predictable it would cease to be life, and be without flavor. \n\n-Eleanor Roosevelt",
        "If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough. \n\n-Oprah Winfrey",
        "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success. \n\n-James Cameron",
        "Life is what happens when you're busy making other plans. \n\n-John Lennon",
    )

     val listQuotes: ArrayList<String>
        get() {
            var list = arrayListOf<String>()
            for (i in quotes.indices) {
                list.add(quotes[i])
            }
            return list
        }
}