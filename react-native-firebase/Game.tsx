import { Text, View, TouchableOpacity } from 'react-native';
import { styles } from './styles';
import {getDBConnection, getSavedGames, saveGame, createTable, deleteTable, deleteGame} from './db/db-services';
import { useAppNavigation } from './utils/useAppNavigation';

export type GameProps = {
    name: string;
    type: number;
    score: number;
    date: string;
};

export default function Game(){
  const navigation = useAppNavigation();
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Game</Text>
      <TouchableOpacity style={styles.button} onPress={navigation.goBack}>
      </TouchableOpacity>
    </View>
  );
}



