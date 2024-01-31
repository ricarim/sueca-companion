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

    cv::namedWindow("Webcam", cv::WINDOW_AUTOSIZE);
    for(;;){
        // Capture next frame
        cv::Mat frame, frame_gray , frame_can;
        cap >> frame;

        // Check if frame was captured successfully
        if(frame.empty()){
            std::cout << "Error reading frame from webcam." << std::endl;
            break;
        }
        cv::cvtColor(frame, frame_gray, cv::COLOR_BGR2GRAY);
        cv::GaussianBlur(frame_gray, frame_gray, cv::Size(5, 5), 0);
        cv::Canny(frame_gray, frame_can, 50, 150);

        std::vector<std::vector<cv::Point> > contours;
        cv::findContours(frame_can, contours, cv::RETR_EXTERNAL, cv::CHAIN_APPROX_SIMPLE, cv::Point(0, 0));

        cv::Mat contourImage(frame_can.size(), CV_8UC3, cv::Scalar(0,0,0));
        cv::Scalar color(255,0,0);
        for(size_t i=0; i<contours.size(); i++){
            cv::drawContours(contourImage, contours, i, color);
        }
        // Display frame
        cv::imshow("Webcam", frame_can);
        cv::imshow("Webcam", contourImage);
    
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
