import * as React from 'react';
import { Text, View, TouchableOpacity, ActivityIndicator, StyleSheet } from 'react-native';
import { styles } from './styles';
import { getDBConnection, getSavedGames, saveGame, createTable, deleteTable, deleteGame } from '../../db/db-services';
import { Camera, CameraType } from 'expo-camera';
import { useAppNavigation } from '../../utils/useAppNavigation';
//import { useTensorflowModel } from 'react-native-fast-tflite';
import { useResizePlugin } from 'vision-camera-resize-plugin';

export type GameProps = {
    name: string;
    type: number;
    score: number;
    date: string;
};

export default function Game() {
    const [hasPermission, requestPermission] = Camera.useCameraPermissions()
    const [type, setType] = React.useState(CameraType.back)
    const navigation = useAppNavigation();
    //const objectDetection = useTensorflowModel(require('../../assets/best_float32.tflite'))
    //const model = objectDetection.state === "loaded" ? objectDetection.model : undefined

    function toggleCameraType() {
        setType(current => (current === CameraType.back ? CameraType.front : CameraType.back));
    }

    /*
    const { resize } = useResizePlugin();

    const frameProcessor = useFrameProcessor((frame) => {
        'worklet'
        if (model == null) return

        console.log('Running inference on ${frame}')
        const resized = resize(frame, {
            scale: {
                width: 192,
                height: 192,
            },
            pixelFormat: 'rgb',
            dataType: 'uint8',
        })
        // 2. Run model with given input buffer synchronously
        const outputs = model.runSync([resized])

        // 3. Interpret outputs accordingly
        const detection_boxes = outputs[0]
        const detection_classes = outputs[1]
        const detection_scores = outputs[2]
        const num_detections = outputs[3]
        console.log(`Detected ${num_detections[0]} objects!`)

        for (let i = 0; i < detection_boxes.length; i += 4) {
            const confidence = detection_scores[i / 4]
            if (confidence > 0.7) {
                // 4. Draw a red box around the detected object!
                const left = detection_boxes[i]
                const top = detection_boxes[i + 1]
                const right = detection_boxes[i + 2]
                const bottom = detection_boxes[i + 3]
                // const rect = SkRect.Make(left, top, right, bottom)
                // canvas.drawRect(rect, SkColors.Red)
                console.log(`Detected object: Left: ${left}, Top: ${top}, Right: ${right}, Bottom: ${bottom}`);
                console.log("Drawing a red box around the detected object!");

            }
        }
    }, [model])

    React.useEffect(() => {
    requestPermission()
  }, [requestPermission])

  console.log(`Model: ${objectDetection.state} (${objectDetection.model != null})`)
*/
    //const camera = Camera.getAvailableCameraDevices();
    //const device = camera[0];
    return (
        <View style={styles.container}>
            <Text style={styles.title}>Game</Text>
            <TouchableOpacity style={styles.button} onPress={navigation.goBack}>
            </TouchableOpacity>
            {/* <iframe src="..." allow="microphone; camera;">*/}
            <Camera style={styles.camera} type={type}>
                <View style={styles.buttonContainer}>
                    <TouchableOpacity style={styles.button} onPress={toggleCameraType}>
                        <Text style={styles.title}>Flip Camera</Text>
                    </TouchableOpacity>
                </View>
            </Camera>
            {/* </iframe>*/}
        </View>
    );
}



