#include <iostream>
#include <opencv2/opencv.hpp>

int main(){
    // Open webcam
    cv::VideoCapture cap(0); // 0 is the default webcam

    // Check if webcam opened successfully
    if(!cap.isOpened()){
        std::cout << "Error opening webcam." << std::endl;
        return -1;
    }

    for(;;){
        // Capture next frame
        cv::Mat frame;
        cap >> frame;

        // Check if frame was captured successfully
        if(frame.empty()){
            std::cout << "Error reading frame from webcam." << std::endl;
            break;
        }

        // Display frame
        cv::imshow("Webcam", frame);
    
        // Wait 10 mms and check if ESC was pressed
        if(cv::waitKey(10) == 27){
            break;
        }
    }

    // Release webcam
    cap.release();
    cv::destroyAllWindows();

    return 0;
}
