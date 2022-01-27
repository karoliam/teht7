package com.karoliinamultas.tiistai2501

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.karoliinamultas.tiistai2501.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var on = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var member = MemberOfParliament.ParliamentMembersData.members

/*        var memberMap: MutableMap<Int, String> = mutableMapOf()
        for(i in 0..member.size.minus(1)){
            memberMap.put(member[i].personNumber, member[i].party)
        }*/

        val parties = MemberOfParliament.ParliamentMembersData.members.map { it.party }.toSet().sorted().toString()
        binding.partiesText.text = parties

        binding.button.setOnClickListener {
            for(i in 0..parties.length) {
                parties[i]
                var input = binding.userInput
                val politician = MemberOfParliament.ParliamentMembersData.members.map { it.last }.toSet().sorted().toString()
                val randomPolitician = politician.random()
                    if (input.equals(parties[i])) binding.politicianName.text = randomPolitician.toString()
                }

            }


        }


    }
}