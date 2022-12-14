# midenfy

Midenfy is a compiler for [Clarity](https://clarity-lang.org/) targeting the [Polygon Miden VM](https://polygon.technology/solutions/polygon-miden). Clarity is a decidable language for smart contracts, initially developed for the [Stacks](https://www.stacks.co/) blockchain.

_The initial version only compiles a very limited subset of Clarity. It is
a proof-of-concept and not yet ready for production use._

The project is in response to the
Polygon Miden team [calling for development](https://github.com/maticnetwork/miden/tree/main/miden) of compilers from high-level blockchain-centric languages:

> Our goal is to make Miden VM an easy compilation target for high-level 
> blockchain-centric languages such as Solidity, Move, Sway, and others. 
> We believe it is important to let people write programs in the languages of 
> their choice. However, compilers to help with this have not been developed yet.

## Usage

Download and change into the directory:

```
$ git clone https://github.com/njordhov/midenfy
$ cd midenfy
```

Execute with docker:

```
$ docker compose run midenfy --help
```

Compile a Clarity contract file into Miden masm:

```
$ cat src/clarity/add.clar
$ docker compose run midenfy src/clarity/add.clar
```

```
$ cat src/clarity/fun.clar
$ docker compose run midenfy src/clarity/fun.clar
```

## Implementation

The compiler is written in [Clojure](https://clojure.org/), the programming language 
[sponsored](https://www.finextra.com/newsarticle/36297/nubank-buys-firm-behind-clojure-programming-language) by [NuBank](https://building.nubank.com.br/clojure-15th-anniversary-a-retrospective/), 
a [notable](https://blog.polygon.technology/nubank-taps-polygon-supernets-for-nucoin-token-launch-loyalty-program/) Polygon partner.

The code can be used in web3 project such as web apps generating custom Miden VM programs,
by using the [Clojurescript](https://clojurescript.org/) compiler. 

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
