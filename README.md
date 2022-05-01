# add-entities-issue

Reproduction of datahike issue when adding lots of individual entities

## Usage

To reproduce, from the main directory, run:
```sh

# If re-running
# rm -rf my-db/
clojure -M -m com.phronemophobic.datahike.add-enties-issue

```
You should see the program print the number of entities added to stdout and eventually crash. For me, it consistently crashed on entity 5408.


## License

Copyright © 2022 Adrian

Distributed under the Eclipse Public License version 1.0.
