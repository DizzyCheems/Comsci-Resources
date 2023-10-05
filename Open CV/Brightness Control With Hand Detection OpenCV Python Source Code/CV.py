import cv2


#Convert AVI to YUV format
VideoCapture = cv2.VideoCapture('file.avi')
fps = VideoCapture.get(cv2.CAP_PROP_FPS)
size = (int(VideoCapture.get(cv2.CAP_PROP_FRAME_WIDTH)), int(VideoCapture.get(cv2.CAP_PROP_FRAME_HEIGHT)))
VideoWriter = cv2.VideoWriter('myoutput.avi', cv2.VideoWriter_fourcc('I', '4', '2', '0'), fps, size)

success, frame = VideoCapture.read()
while success:
    VideoWriter.write(frame)
    success, frame = VideoCapture.read()


CameraCapture = cv2.VideoCapture(0)
fps =  30
size = (int(CameraCapture.get(cv2.CAP_PROP_FRAME_WIDTH)),
       int(CameraCapture.get(cv2.CAP_PROP_FRAME_HEIGHT))) 
    
VideoWriter = cv2.VideoWriter('Myoutput.avi', cv2.VideoWriter_fourcc('I', '4', '2', '0'), fps, size)
success, frame = CameraCapture.read()
numframesremaining = 10*(fps)-1
while success and numframesremaining > 0:
    VideoWriter.write(frame)
    success, frame = CameraCapture.read()
    numframesremaining -=1


img = cv2.imread('image.jpg')
cv2.imshow('image', img)
cv2.waitKey()
cv2.destroyAllWindows()