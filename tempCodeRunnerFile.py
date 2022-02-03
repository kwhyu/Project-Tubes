import cv2
import numpy

video = cv2.VideoCapture("Bahan/Video/SD_Slomo.mp4")

while True:
    sukses, frame = video.read()
    cv2.imshow("Original", frame)

    hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
    lower_red = numpy.array([169, 100, 100])
    upper_red = numpy.array([189, 255, 255])

    detect = cv2.inRange(hsv, lower_red, upper_red)

    contours, hierarchy=cv2.findContours(detect, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    if len(contours)!=0:
        for contour in contours:
            if cv2.contourArea(contour) > 500:
                x,y,w,h = cv2.boundingRect(contour)
                cv2.rectangle(frame,(x,y), (x+w, y+h),(0, 255,0), 2)
                cv2.putText(frame, "Ini Merah", (x,y), cv2.FONT_HERSHEY_SCRIPT_SIMPLEX, 2, (0, 255, 0), 3)


    cv2.imshow("Original", frame)
    cv2.imshow("Hasil Deteksi", detect)


    if cv2.waitKey(1) == ord('q'):
        cv2.destroyAllWindows
        video.release()
        break