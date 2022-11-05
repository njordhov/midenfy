# CONTRIBUTING

## EXECUTE WITH HOTLOAD 

Execute the script with hotloading and repeat on code changes:

$ `docker-compose run script --help`

## START WATCHER

Start a watcher in the background, which will recompile the script and hotload 
code whenever files are changed:

$ `docker-compose up -d watch`

Open a dashboard for the watcher from a web browser (if at first you fail, try again):

$ `open http://localhost:9630/dashboard`
