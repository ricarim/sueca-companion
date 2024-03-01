import { useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import { Text, View, TouchableOpacity} from 'react-native';
import { styles } from './styles';
import Modals from '../../components/Modal/Modal';
import Input from '../../components/Input/Input';
import {getDBConnection, getSavedGames, saveGame, createTable, deleteTable, deleteGame} from '../../db/db-services';
import {useAppNavigation} from '../../utils/useAppNavigation';

export default function MenuScreen() {
    const navigation = useAppNavigation();
    const [ModalVisibleNew, setModalVisibleNew] = useState(false);
    const [ModalVisibleLoad, setModalVisibleLoad] = useState(false);

    const toggleModalNew = () => {
        setModalVisibleNew(!ModalVisibleNew);
    }

    const toggleModalLoad = () => {
        setModalVisibleLoad(!ModalVisibleLoad); }

    
    const _renderForm = () => {
        return (
            <View style={styles.form}>
            <View style={styles.input}>
              <Input
                name="Name"
                placeholder="Enter the Game Name to be saved"
                autoCapitalize="none"
                keyboardType="default"
              />
            </View>
          </View>
        );
    }

    return (
        <>
        <View style={styles.container}>
            <Text style={styles.title}>Sueca Companion</Text>
            <StatusBar style="auto" />
            <View style={styles.buttonContainer}>
                <TouchableOpacity style={styles.button} onPress={toggleModalNew}>
                    <Text style={styles.buttonText}>New Game</Text>
                </TouchableOpacity>
                <TouchableOpacity style={styles.button} onPress={toggleModalLoad}>
                    <Text style={styles.buttonText}>Load Game</Text>
                </TouchableOpacity>
                <TouchableOpacity style={styles.button}>
                    <Text style={styles.buttonText}>Tutorial</Text>
                </TouchableOpacity>
                <TouchableOpacity style={styles.button}>
                    <Text style={styles.buttonText}>Settings</Text>
                </TouchableOpacity>
            </View>
        </View>

        <Modals
            visible={ModalVisibleNew}
            modalText="New Game"
            buttonTitle="Start Game"
            onAction={() => { 
                navigation.navigate('Onboarding', {screen: 'Game'})
                setModalVisibleNew(false);
            }}
            onClose={toggleModalNew}
        >
            {_renderForm()}
        </Modals>

        <Modals
            visible={ModalVisibleLoad}
            modalText="Load Game"
            buttonTitle="Load Game"
            onAction={() => { 
                navigation.navigate('Onboarding', {screen: 'Game'})
                setModalVisibleLoad(false);
            }}
            onClose={toggleModalLoad}
        >
            <Text>Load Game</Text>
        </Modals>
        </>
    );
}


