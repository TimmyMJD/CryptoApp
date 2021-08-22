package com.example.cryptoapp.api

import com.example.cryptoapp.pojo.CoinInfoListOfData
import com.example.cryptoapp.pojo.CoinPriceInfoRawData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAMS_API_KEY) apiKey: String = "eaa05c7c7009cea7f4849df993e7ebbcbdfb68a9fd0ce6dad1af330aaa2c93ab",
        @Query(QUERY_PARAMS_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAMS_TO_SYMBOL) tSym: String = CURRENCY
    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAMS_API_KEY) apiKey: String = "eaa05c7c7009cea7f4849df993e7ebbcbdfb68a9fd0ce6dad1af330aaa2c93ab",
        @Query(QUERY_PARAMS_FROM_SYMBOLS) fSyms: String = CURRENCY ,
        @Query(QUERY_PARAMS_TO_SYMBOLS) tSyms: String = CURRENCY

        ): Single<CoinPriceInfoRawData>

    companion object{
        private const val QUERY_PARAMS_API_KEY = "api_key"
        private const val QUERY_PARAMS_LIMIT = "limit"
        private const val QUERY_PARAMS_TO_SYMBOL  = "tsym"
        private const val QUERY_PARAMS_TO_SYMBOLS  = "tsyms"
        private const val QUERY_PARAMS_FROM_SYMBOLS  = "fsyms"

        private const val CURRENCY = "USD"
    }
}