See file `sidecar-proxy-perspective-30s-300c.pcapng` and search for tcp.stream eq 1840 for an example of upstream sending RST right after client send a request

See file `sidecar-proxy-perspective-30s-300c-request-id.pcapng` and search for `tcp.stream eq 2018` for an example of upstream sending RST.
To tally the actual 503 recorded, look into `access-log-capture.txt` 
Search for 'request-id: b0a11b12-45b0-4c87-949b-a54b403d8626'
Then, find in the pcapng capture and look for the same request id using filter `http contains "b0a11b12-45b0-4c87-949b-a54b403d8626"` and follow TCP stream. You can see that it will not receive any reply. For comparison sake, can change to a successful request. By right you would see "request-response" pair. 
