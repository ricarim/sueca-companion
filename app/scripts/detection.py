from ultralytics import YOLO
import cv2
import math

card = ""
cardId = ""
model = YOLO('../yolov8/best.pt')
cap = cv2.VideoCapture(0)

while True:
    # Read an Frame
    ret, frame = cap.read()
    if not ret:
        break
    
    # Frame detection
    results = model(frame)

    detected = False
    for r in results:
        boxes = r.boxes
        class_names = r.names
        for box in boxes:
            # Confidence
            conf = math.ceil((box.conf[0] * 100)) / 100
            # Class Name
            cls = int(box.cls[0])
            if conf > 0.5:
                card = class_names[cls]
                cardId = cls
                detected = True

    if detected == True:
        break

print(card, cardId)
                
cap.release()
cv2.destroyAllWindows()

