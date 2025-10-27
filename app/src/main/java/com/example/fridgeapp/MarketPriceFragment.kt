package com.example.fridgeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class MarketPriceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    MarketPriceScreen()
                }
            }
        }
    }
}

@Composable
fun MarketPriceScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("💲 실시간 식재료 가격 정보", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))

        // 예시 데이터 (나중에 API 연동 가능)
        val items = listOf(
            MarketPrice("돼지고기 (삼겹살)", 18900, 19500, -600, -3, "하락 추세"),
            MarketPrice("닭고기 (닭가슴살)", 8500, 8200, 300, 4, "상승 추세"),
            MarketPrice("계란 (30개)", 7000, 7200, -200, -2, "하락 추세")
        )

        items.forEach { item ->
            MarketPriceCard(item)
            Spacer(Modifier.height(8.dp))
        }

        Text(
            "💡 Tip: 가격 정보를 참고하여 장보기 계획을 세워보세요!",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

data class MarketPrice(
    val name: String,
    val current: Int,
    val average: Int,
    val diff: Int,
    val percent: Int,
    val trend: String
)

@Composable
fun MarketPriceCard(item: MarketPrice) {
    val color = if (item.diff < 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
    val icon = if (item.diff < 0) "🔻" else "🔺"

    Card(
        Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(item.name, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(4.dp))
            Text("${item.current}원 / 1kg", style = MaterialTheme.typography.bodyLarge)

            Spacer(Modifier.height(6.dp))
            Text("평균가: ${item.average}원", style = MaterialTheme.typography.bodySmall)
            Text("가격 차이: ${item.diff}원 (${item.percent}%)", color = color)
            Text("$icon ${item.trend}", color = color)
        }
    }
}
