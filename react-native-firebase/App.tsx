import { SafeAreaView } from "react-native";
import Home from "./screens/Home/Home";
import {styles} from "./styles";
import Game from "./Game";

export default function App() {
  return (
    <SafeAreaView style={styles.container}>
        <Home />
    </SafeAreaView>
  );
}
