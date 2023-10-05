import cv2

#img = cv2.imread('image.jpg')
#cv2.imshow('image', img)
#cv2.waitKey()
#cv2.destroyAllWindows()


clicked = False
def onMouse(event, x,y, flags,param):
    global clicked
    if event == cv2.EVENT_LBUTTONUP:
        clicked = True

cameraCapture = cv2.VideoCapture(0)
cv2.namedWindow('Justine')
cv2.setMouseCallback('Justine', onMouse)

print('showing camera feed., press any key to exit')
success, frame = cameraCapture.read()
while success and cv2.waitKey(1) == -1 and not clicked:
    cv2.imshow('Justine', frame)
    success, frame = cameraCapture.read()

cv2.destroyAllWindows('Justine')
cameraCapture.release()
