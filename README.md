# midenfy

Developer Tool to compile Clarity smart contracts, targeting the [Polygon Miden VM](https://polygon.technology/solutions/polygon-miden).

[Clarity](https://clarity-lang.org/) is a decidable language for smart contracts, 
initially targeting the [Stacks](https://www.stacks.co/) blockchain.

Midenfy is a compiler for Clarity targeting the Miden VM, in response to the
Polygon Miden team calling for compilers to be developed:

> Our goal is to make Miden VM an easy compilation target for high-level 
> blockchain-centric languages such as Solidity, Move, Sway, and others. 
> We believe it is important to let people write programs in the languages of 
> their choice. However, compilers to help with this have not been developed yet.

https://github.com/maticnetwork/miden/tree/main/miden

The compiler is written in [Clojure](https://clojure.org/), the programming language 
[sponsored](https://www.finextra.com/newsarticle/36297/nubank-buys-firm-behind-clojure-programming-language) by [NuBank](https://building.nubank.com.br/clojure-15th-anniversary-a-retrospective/), 
which [builds](https://blog.polygon.technology/nubank-taps-polygon-supernets-for-nucoin-token-launch-loyalty-program/) their blockchain services on Polygon.

The code can be used in web3 project such as web apps generating custom Miden VM programs,
by using the [Clojurescript](https://clojurescript.org/) compiler. 

Note: The initial version only supports a very limited subset of Clarity, and are
not yet ready for production use.

PS: Here is a smart contract deployed to the Mumbai Testnet:
https://mumbai.polygonscan.com/address/0x3A788CB91F3Bf73b5A4d373ff3533328286caf22

## Usage

Execute with docker:

```
$ docker compose run midenfy --help
```

Compile a Clarity contract file into Miden masm:

```
$ docker compose run midenfy src/clarity/add.clar
```

```
$ docker compose run midenfy src/clarity/fun.clar
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
