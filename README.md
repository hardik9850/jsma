# Java SmugMug API

The Java SmugMug API is a library written to wrap the [SmugMug API 1.3.0](http://wiki.smugmug.net/display/API/API+1.3.0). It is essentially designed to be as intuitive as possible, making it easy to include in your own project and quickly work with the api. 

## Project Setup

JSMA is still a work in progress, and should be considered in an alpha state. As such currently you need to use get the source from the git repo and compile it yourself.

### Dependencies
 Below are the list of the top level projects that JSMA uses along with a link to their respective licenses for those that are interested.
 
* [Jersey](http://jersey.java.net/)
  Provides the infrastructure to make the api calls to SmugMug and parse the JSON reposne into Java objects. ([License](http://glassfish.java.net/public/CDDL+GPL_1_1.html))
* [Simple Logging Facade for Java (SLF4J)](http://www.slf4j.org/)  
  Used to handle logging in a way that will still allow you the freedom to pick whichever logging framework you would like. ([License](http://www.slf4j.org/license.html))
* [Apache Commons Lang](http://commons.apache.org/lang/)  
  TODO: Find what I use this for. ([License](http://www.apache.org/licenses/)).
* [Apache Commons Codec](http://commons.apache.org/codec/)  
  Used to handle generating the MD5Sum of files (and I think that is it). I would like to remove this depency eventually, since we use such a small part. ([License](http://www.apache.org/licenses/)).

### Examples

Example code can be found in the [test directory](https://github.com/jkschoen/jsma/tree/master/src/test/java/com/github/jkschoen/jsma/examples). In order to run the examples you need to [Apply for an API Key](http://www.smugmug.com/hack/apikeys) with SmugMug.

To run the examples you need to edit [UserConfig.java](https://github.com/jkschoen/jsma/blob/master/src/test/java/com/github/jkschoen/jsma/examples/UserConfig.java) and set `APP_NAME`, `CONSUMER_SECRET`, `CONSUMER_KEY`, `OAUTH_TOKEN_ID`, and `OAUTH_TOKEN_SECRET` with the appropriate values for your application and account. **NOTE**: You can get the values for `OAUTH_TOKEN_ID` and `OAUTH_TOKEN_SECRET` by settting the other three and running the [AuthExample](https://github.com/jkschoen/jsma/blob/master/src/test/java/com/github/jkschoen/jsma/examples/AuthExample.java). 

The current List of examples are:

* [AuthExample](https://github.com/jkschoen/jsma/blob/master/src/test/java/com/github/jkschoen/jsma/examples/AuthExample.java) - Good starting point to see how to get your application authorized with a users account.  
* [AlbumExample](https://github.com/jkschoen/jsma/blob/master/src/test/java/com/github/jkschoen/jsma/examples/AlbumExample.java) - Shows the basic functionality of working with the Albums API. 
* [ImageExample](https://github.com/jkschoen/jsma/blob/master/src/test/java/com/github/jkschoen/jsma/examples/ImageExample.java) - Shows how to upload an image to SmugMug.

Then you just can just run all the examples, and they will pull the values from [UserConfig.java](https://github.com/jkschoen/jsma/blob/master/src/test/java/com/github/jkschoen/jsma/examples/UserConfig.java).

## Bug Reports/Issues/Feature Requests

If you encounter a bug or issue please create a [New Issue here on Github](https://github.com/jkschoen/jsma/issues/new) after checking looking through the [Other Issues](https://github.com/jkschoen/jsma/issues) to see if it has been reported already. If it has then feel free to comment on the existing issue with any additional information. 

If you are creating a new issue, I request you put as much information as possible. Method called, with what parameters, if an exception is thrown then include the stacktrace. Basically all the info someone would need to debug the problem.

If there is a feature you want, pretty much follow the same procedure. Check if there is already an issue for it, if so feel free to comment, if not make one with as much detail of what you want as possible. 

## Contributing changes

I will gladly accept pull requests for just about all aspects of the project. It you have a something you would like to contribute here is the general workflow at the moment (this may change as I become more familar with git): 

  - fork the project
  - create a new branch
  - make your additions/changes/fixes in the new branch
  - submit a pull request with a fairly decent description of what it is about.
 
When writing your commit messages on your branch try to use a decent commit message. I am horrible about this myself. But basically enough that if someone else read it they would know the point of the changes. Feel free to call me out on this also, as I am trying to break my habit of writing commit messages that read "Fixed stuff" and "Really fixed stuff this time". 

### Unit Tests and Examples

If you have some spare time and wish to contribute, it will very much appreciated.

The current unit tests cover the Sample Responses given in the API documentation. It does not currently cover all possible mappings. Ideally I would eventually include unit tests to test all these mappings across the classes in the model pacakage. 

It would be nice to provide a few examples of working with the api for each of the API classes. If you happen to to struggle with some aspect of using the library, it would be great to provide a solution via an example for others to learn from. I am not sure it is necessary to have an example of every possible call, but if someone wanted to do that or even just a few it would welcomed. 

## License

JSMA is released under the MIT License which is simple and easy to understand, while placing almost no restrictions on what you can do with the project.

[MIT License](https://github.com/jkschoen/jsma/blob/master/LICENSE) ([More Information](http://en.wikipedia.org/wiki/MIT_License))