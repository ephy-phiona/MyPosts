package dev.phiona.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.phiona.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPosts()

            }


    fun getPosts(){
        val retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=retrofit.getPosts()


        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    val  post=response.body()
                    Log.d("TAG", post.toString())
                    Toast.makeText(baseContext, "fetched ${post!!.size} posts",
                    Toast.LENGTH_LONG).show()

                    var commentsAdapter=RetrofitRvAdapter(baseContext,post)
                    binding.rvComments.layoutManager=LinearLayoutManager(baseContext)
                    binding.rvComments.adapter=commentsAdapter
                }

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }
        })
    }
}