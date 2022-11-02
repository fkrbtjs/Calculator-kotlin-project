package aop.part3.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import aop.part3.calc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var dataList: MutableList<DataVO>
    lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataList = mutableListOf<DataVO>()


        val layoutManager: LinearLayoutManager = selectLayoutManager(1)

        customAdapter = CustomAdapter(dataList, this)
        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.adapter = customAdapter



        var value: Any = 0
        var result :Any = 0
        var calc = ""


        binding.tv0.setOnClickListener { binding.tvCalc.append("0") }
        binding.tv1.setOnClickListener { binding.tvCalc.append("1") }
        binding.tv2.setOnClickListener { binding.tvCalc.append("2") }
        binding.tv3.setOnClickListener { binding.tvCalc.append("3") }
        binding.tv4.setOnClickListener { binding.tvCalc.append("4") }
        binding.tv5.setOnClickListener { binding.tvCalc.append("5") }
        binding.tv6.setOnClickListener { binding.tvCalc.append("6") }
        binding.tv7.setOnClickListener { binding.tvCalc.append("7") }
        binding.tv8.setOnClickListener { binding.tvCalc.append("8") }
        binding.tv9.setOnClickListener { binding.tvCalc.append("9") }
        binding.tvDot.setOnClickListener { binding.tvCalc.append(".") }
        binding.tvBack.setOnClickListener { binding.tvCalc.setText(binding.tvCalc.text.dropLast(1)) }

        binding.tvCancle.setOnClickListener {
            binding.tvCalc.setText("")
            binding.tvResult.setText("")
            value = 0
        }

        binding.tvPlus.setOnClickListener {
            calc = "plus"
            value = binding.tvCalc.text.toString().toDouble()
            binding.tvCalc.setText("")
            binding.tvResult.setText(value.toString())

        }

        binding.tvMinus.setOnClickListener {
            calc = "minus"
            value = binding.tvCalc.text.toString().toDouble()
            binding.tvCalc.setText("")
            binding.tvResult.setText(value.toString())

        }
        binding.tvMultiply.setOnClickListener {
            calc = "multiply"
            value = binding.tvCalc.text.toString().toDouble()
            binding.tvCalc.setText("")
            binding.tvResult.setText(value.toString())

        }
        binding.tvDevide.setOnClickListener {
            calc = "devide"
            value = binding.tvCalc.text.toString().toDouble()
            binding.tvCalc.setText("")
            binding.tvResult.setText(value.toString())

        }




        binding.tvEqual.setOnClickListener {
            when (calc) {
                "plus" -> {
                    result =
                        binding.tvResult.text.toString().toDouble() + binding.tvCalc.text.toString()
                            .toDouble()
                    var dataVO :DataVO = DataVO("${binding.tvResult.text} + ${binding.tvCalc.text}","= ${result}")
                    refreshRecyclerView(dataVO)
                }
                "minus" -> {
                    result =
                        binding.tvResult.text.toString().toDouble() - binding.tvCalc.text.toString()
                            .toDouble()
                    var dataVO :DataVO = DataVO("${binding.tvResult.text} - ${binding.tvCalc.text}","= ${result}")
                    refreshRecyclerView(dataVO)
                }
                "multiply" -> {
                    result =
                        binding.tvResult.text.toString().toDouble() * binding.tvCalc.text.toString()
                            .toDouble()
                    var dataVO :DataVO = DataVO("${binding.tvResult.text} x ${binding.tvCalc.text}","= ${result}")
                    refreshRecyclerView(dataVO)
                }
                "devide" -> {
                    result =
                        binding.tvResult.text.toString().toDouble() / binding.tvCalc.text.toString()
                            .toDouble()
                    var dataVO :DataVO = DataVO("${binding.tvResult.text} / ${binding.tvCalc.text}","= ${result}")
                    refreshRecyclerView(dataVO)
                }

            }
            binding.tvResult.setText(result.toString())
            binding.tvCalc.setText(result.toString())
        }

        binding.tvHistory.setOnClickListener {
            binding.lnHisotry.visibility = View.VISIBLE
        }

        binding.btnOut.setOnClickListener {
            binding.lnHisotry.visibility = View.GONE
        }

    }

    private fun selectLayoutManager(i: Int): LinearLayoutManager {
        lateinit var layoutManager: LinearLayoutManager
        if (i == 1) {
            layoutManager = LinearLayoutManager(this)
        } else if (i == 2) {
            layoutManager = LinearLayoutManager(this)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        }

        return layoutManager
    }

    public fun refreshRecyclerView(dataVO: DataVO){
        dataList.add(dataVO)
        customAdapter.notifyDataSetChanged()
    }

    public fun refreshRecyclerViewDrop(dataVO: DataVO) {
        dataList.remove(dataVO)
        customAdapter.notifyDataSetChanged()

    }
}