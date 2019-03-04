# Greyscale
Converts a color RGB image to gray
it scales according to the arguments
and save as local image-file


start with Runner.java main(String args[])

args[0] - String path to image in URL format (http(s):// or file:/)

args[1] - Integer Width image after scales > 0

args[2] - Integer Height image after scales > 0



====Examples argument====

"file:./input.png 100 100"

convert locale input.png to gracyscale 100x100px

"https://sun1-3.userapi.com/c847122/v847122938/1b55ae/We3mg9d8nZc.jpg 100 100"

convert jpg and save local to output.jpg 100x100px

"file:./input.png 100"

don't resize height


"file:./input.png 0 100"

don't resize width


"file:./input.png 0 0"

"file:./input.png -100 -50"

"file:./input.png"

don't scales image

====Supported image formats====

PNG, JPG, JPEG, BMP, GIF

====Errors and results can be tracked in the====

log.txt
