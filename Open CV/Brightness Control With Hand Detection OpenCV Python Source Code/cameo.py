import cv2
from managers import WindowManager, CaptureManager
import filters
class Cameo(object):
    def __init__(self):
        self._windowManager = WindowManager('Cameo', self.onKeypress)
        self._captureManager = CaptureManager(cv2.VideoCapture(0), self._windowManager, True)

    def run(self):
        self._windowManager.createWindow()
        while self._windowManager.isWindowCreated:
            self._captureManager.enterFrame()
            frame = self._captureManager.frame

            if frame is not None:
                #TODO
                pass
            filters.strokeEdge(frame,frame)
            self._captureManager.exitFrame()
            self._windowManager.processEvents()

    def onKeypress(self, keycode):
        if keycode == 32:  #spacebar 
            self._captureManager.writeImage('screencapture.png')
        elif keycode == 9:# tabbtn
            if not self._captureManager.isWritingVideo:
                self._captureManager.startWritingVideo('screencast.avi')
            else:
                self._captureManager.stopWritingVideo()
        elif keycode == 27: #escape btn
            self._windowManager.destroyWindow()

if __name__ =="__main__":
    Cameo().run()