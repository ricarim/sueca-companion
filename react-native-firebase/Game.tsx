import { Text, View, TouchableOpacity } from 'react-native';
import { styles } from './Styles';

export default function Game() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Game</Text>
      <TouchableOpacity style={styles.button}>
        <Text style={styles.buttonText}>Start</Text>
      </TouchableOpacity>
    </View>
  );
}



