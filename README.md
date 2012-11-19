# Java SmugMug API

The Java SmugMug API is a library written to wrap the [SmugMug API 1.3.0](http://wiki.smugmug.net/display/API/API+1.3.0). It is essentially designed to be as intuitive as possible, making it easy to include in your own project and quickly work with the api. 

## License

## Project Setup

JSMA is still a work in progress, and should be considered in an alpha state. As such currently you need to use get the source from the git repo and compile it yourself.

## Examples

Example code can be found in the [test directory](https://github.com/jkschoen/jsma/tree/master/src/test/java/com/github/jkschoen/jsma/examples). In order to run the examples you need to [Apply for an API Key](http://www.smugmug.com/hack/apikeys) with SmugMug.

To run the examples you need to edit [UserConfig.java](https://github.com/jkschoen/jsma/blob/master/src/test/java/com/github/jkschoen/jsma/examples/UserConfig.java) and set `APP_NAME`, `CONSUMER_SECRET`, `CONSUMER_KEY`, `OAUTH_TOKEN_ID`, and `OAUTH_TOKEN_SECRET` with the appropriate values for your application and account. **NOTE**: You can get the values for `OAUTH_TOKEN_ID` and `OAUTH_TOKEN_SECRET` by settting the other three and running the [AuthExample](https://github.com/jkschoen/jsma/blob/master/src/test/java/com/github/jkschoen/jsma/examples/AuthExample.java). 

The current List of examples are:

*[AuthExample](https://github.com/jkschoen/jsma/blob/master/src/test/java/com/github/jkschoen/jsma/examples/AuthExample.java) - Good starting point to see how to get your application authorized with a users account.
*[AlbumExample](https://github.com/jkschoen/jsma/blob/master/src/test/java/com/github/jkschoen/jsma/examples/AlbumExample.java) - Shows the basic functionality of working with the Albums API. 

Then you just can just run all the examples, and they will pull the values from [UserConfig.java](https://github.com/jkschoen/jsma/blob/master/src/test/java/com/github/jkschoen/jsma/examples/UserConfig.java).

## Contributing changes

### Unit Tests