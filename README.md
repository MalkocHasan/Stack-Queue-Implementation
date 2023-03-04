# Stack-Queue-Implementation
Hasan Malkoc BBM104_AS4 28/05/2021

## 1 Introduction
In this assignment, you are going to simulate a vending machine scenario. According to this
scenario, you are given several vending parts such as biscuits, chocolates, drinks and so on. In
each part of vending machine, there are vending items. You have also token box for store your
tokens. There are also different tokens for each part of vending machine


## 2 Scenario
You are expected to complete tasks that are given tasks.txt according to input files and produce
an output file. The informations about parts, items, tokens and tasks are in the input files. In
parts.txt file, you are given several parts of vending machine. These parts are modeled as stacks
that are following the last-in-first-out policy. And each part has items given in items.txt. Each
item should be in corresponding part of vending machine. You have also token box for store
your tokens which are given in tokens.txt. This box is modeled as priority queue. In a priority
queue, an item with high priority is served before an element with low priority. In this assignment,
the higher value token has more priority. If two tokens have the same value, they should serve
according to the order in which they were enqueued. In our scenario, you have two different tasks
that are BUY and PUT. These will be given in tasks.txt. There may be more than one of each in
tasks.txt.

## 3 Experiment
Your system will take the input files as parameters that are parts.txt, items.txt, tokens.txt and
tasks.txt. The initial status of the parts of the vending machine can be obtain by reading the
input from these files. The status of each part should be written into the output file after the
tasks are completed.
