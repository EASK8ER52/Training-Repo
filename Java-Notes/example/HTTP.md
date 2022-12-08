# What is HTTP?
Hyper Text Transfer Protocol (http) is the most popular way of transfering information across the web in modern times. It is a request/response system that guarantees a response for every request made. There are a few standard components of an HTTP request you should be familiar with:
- uri
    - This is the part of the request that tells the web server what information you want
- body
    - many http requests are going to contain a body: this is the information that is needed to complete whatever request you are making

You also should be familiar with following components of an HTTP response:
- body
    - this contains whatever information you requested (or it could be an error message)
- status code [more info on status codes](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
)
    - this is a number that gives an immediate indication of how your request was handled
    - there are multiple http status levels you can get
        - 100 is informational
        - 200 is success
        - 300 is redirect
        - 400 is user error (clientside error)
        - 500 is server error (the developer messed up)
            - 500 is BAD: you do not want 500 status codes being returned to your users