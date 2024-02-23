import { PropsWithChildren } from 'react';
import { Text, View, TouchableOpacity, Pressable, Modal } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import { styles } from './styles';

interface ModalProps{
    visible: boolean;
    modalText: string;
    buttonTitle: string;
    onAction: () => void;
    onClose: () => void;
}

export default function Modals({
        visible,
        modalText,
        buttonTitle,
        onAction,
        onClose,
        children
    }: PropsWithChildren<ModalProps>) {
    return (
        <Modal animationType="slide" transparent={true} visible={visible} onRequestClose={onClose}>
            <View style={styles.container}>
            <View style={styles.modalView}>
            <View style={styles.modalHeader}>
                <View />
                <Text style={styles.modalText}>{modalText}</Text>
                <Pressable onPress={onClose}>
                    <Ionicons name="close" size={30} color="black" />
                </Pressable>
            </View>
                <View>
                {children}
                </View>
                <View style={styles.modalButton}>
                <TouchableOpacity onPress={onAction} style={styles.button}>
                    <Text style={styles.buttonText}>{buttonTitle}</Text>
                </TouchableOpacity>
                </View>
            </View>
            </View>
        </Modal>
    );
}

