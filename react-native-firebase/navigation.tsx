import Home from './screens/Home/Home';
import Game from './Game';
import { NavigatorScreenParams } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

export type RootStackParamList = {
    Onboarding: NavigatorScreenParams<OnboardingStackParamList>;
}

export type OnboardingStackParamList = {
    Home: undefined;
    Game: undefined;
}

const RootStack = createNativeStackNavigator<RootStackParamList>();
const OnboardingStack = createNativeStackNavigator<OnboardingStackParamList>();

const OnboardingNavigator = () => {
    return (
        <OnboardingStack.Navigator
            screenOptions={{
                headerShown: false
            }}
        >
            <OnboardingStack.Screen name="Home" component={Home} />
            <OnboardingStack.Screen name="Game" component={Game} />
        </OnboardingStack.Navigator>
    );
};

export const RootNavigator = () => {
    return (
        <RootStack.Navigator
            screenOptions={{
                headerShown: false
            }}
        >
            <RootStack.Screen name="Onboarding" component={OnboardingNavigator} />
        </RootStack.Navigator>
    );
};
