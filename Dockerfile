FROM clojure:latest

RUN apt-get update 
RUN apt-get install -y curl
RUN curl -sL https://deb.nodesource.com/setup_16.x | bash -
RUN apt-get install -y apt-utils
RUN apt-get autoremove -y
RUN apt-get install -y nodejs
RUN node -v

COPY . /app
WORKDIR /app
RUN npm install
RUN npx shadow-cljs release script
RUN echo 'alias midenfy="node /app/midenfy.js"' >> ~/.bashrc

WORKDIR /home

ENTRYPOINT ["bash"]
