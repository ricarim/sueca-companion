import { Text, TextInput, TextInputProps, View } from "react-native";
import {styles} from "./styles";

type InputProps = TextInputProps & {
  name: string;
};


export default function Input({ name, ...rest }: InputProps) {
  return (
    <View>
      <Text style={styles.name}>{name}</Text>
      <View style={styles.textInput}>
        <TextInput {...rest} style={styles.input} />
      </View>
    </View>
  );
}
