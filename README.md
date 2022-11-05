# midenfy

Generate code for the Polygon Miden VM

> Our goal is to make Miden VM an easy compilation target for high-level 
> blockchain-centric languages such as Solidity, Move, Sway, and others. 
> We believe it is important to let people write programs in the languages of 
> their choice. However, compilers to help with this have not been developed yet.

https://github.com/maticnetwork/miden/tree/main/miden

## Usage 

```
$ docker compose run midenfy --help
``` 

## Miden

> Miden VM is a zero-knowledge virtual machine written in Rust. For any program 
> executed on Miden VM, a STARK-based proof of execution is automatically generated. 
> This proof can then be used by anyone to verify that the program was executed correctly"

https://github.com/maticnetwork/miden
https://wiki.polygon.technology/docs/miden/intro/main/


> this approach allows us to keep the VM flexible enough to be a compilation 
> target of other higher-level languages. Of special interest are safe 
> blockchain-centric languages

https://blog.polygon.technology/polygon-announces-polygon-miden-a-stark-based-ethereum-compatible-rollup/

## Polygon on Docker

How to run a Polygon (Matic) Mainnet Node with Docker:
https://chasewright.com/how-to-run-a-polygon-matic-mainnet-node/

https://hub.docker.com/u/maticnetwork
