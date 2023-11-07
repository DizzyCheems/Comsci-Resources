import cv2
import numpy as np

img = cv2.imread("image.jpg", 0)
cv2.imwrite("image.jpg", cv2.Canny(img,200, 300))
cv2.imshow("image", cv2.imread("image.jpg"))
cv2.waitKey()
cv2.destroyAllWindows()