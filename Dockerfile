FROM clojure:latest

RUN apt-get update 
RUN apt-get install -y curl
RUN curl -sL https://deb.nodesource.com/setup_16.x | bash -
RUN apt-get install -y apt-utils
RUN apt-get autoremove -y
RUN apt-get install -y nodejs
RUN node -v

WORKDIR /home

ENTRYPOINT ["bash"]
