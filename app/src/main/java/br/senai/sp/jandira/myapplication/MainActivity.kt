package br.senai.sp.jandira.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
//import androidx.navigation.compose.composable
import br.senai.sp.jandira.myapplication.login.screen.LoginScreen
import br.senai.sp.jandira.myapplication.menu.screen.MenuScreen
import br.senai.sp.jandira.myapplication.pedido.screen.PedidoScreen
import br.senai.sp.jandira.myapplication.perfil.screen.PerfilScreen
import br.senai.sp.jandira.myapplication.ui.theme.MyApplicationTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "login",
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentScope.SlideDirection.Up,
                                tween(3000)
                            ) +
                            fadeOut(tween(600))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                AnimatedContentScope.SlideDirection.Down,
                                tween(350)
                            ) +
                                    fadeIn(tween(600))
                        }
                    ) {
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "menu") { MenuScreen(navController) }
                        composable(route = "perfil") { PerfilScreen(navController) }
                        composable(route = "pedido") { PedidoScreen(navController) }
                    }
                }
            }
        }
    }
}