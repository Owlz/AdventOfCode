FROM gitpod/workspace-full

RUN sudo apt-get update \
&& sudo apt-get install -y haskell-platform \
&& sudo rm -rf /var/lib/apt/lists/*

# initialise
USER gitpod
RUN curl -sSL https://get.haskellstack.org/ | sh \
 && stack setup && stack install hlint
USER root