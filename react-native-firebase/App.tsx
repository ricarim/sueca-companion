import { SafeAreaView } from "react-native";
import { styles } from "./styles";
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { RootNavigator } from "./navigation";

const Stack = createNativeStackNavigator();

export default function App() {
    return (
        <NavigationContainer>
            <SafeAreaView style={styles.container}>
                <RootNavigator/>
            </SafeAreaView>
        </NavigationContainer>
    );
}
