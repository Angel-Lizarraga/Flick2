package jose.angel.flick2.data

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.InputStreamReader

object DataProvider {
    var shows = listOf<Show>()
    fun init(context: Context){
        shows = getShows(context)
    }
    fun getShows(context: Context): List<Show> {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val jsonAdapter = moshi.adapter(Array<Show>::class.java)

        // Leer el JSON desde la carpeta de  assets
        val inputStream = context.assets.open("shows.json")
        val json = InputStreamReader(inputStream).readText()

        return jsonAdapter.fromJson(json)?.toList() ?: emptyList()
    }
}