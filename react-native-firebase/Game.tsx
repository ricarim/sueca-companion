import { Text, View, TouchableOpacity } from 'react-native';
import { styles } from './styles';
import {getDBConnection, getSavedGames, saveGame, createTable, deleteTable, deleteGame} from './db/db-services';

export type GameProps = {
    name: string;
    type: number;
    score: number;
    date: string;
};

export default function Game({
    name,
    type,
    score,
    date,
    }: GameProps) {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Game</Text>
    </View>
  );
}



