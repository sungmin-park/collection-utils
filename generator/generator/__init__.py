import click

import os
from jinja2 import Environment, PackageLoader
from os import path

env = Environment(loader=PackageLoader(__name__, 'templates'))
package_root = path.join(path.dirname(__file__), '..', '..', 'src', 'main',
                         'java', 'com.github.parksungmin.collectionUtils')


def render_template(name, **data):
    return env.get_template(name).render(**data)


def write(name, string):
    if not path.exists(package_root):
        os.makedirs(package_root)
    with open(path.join(package_root, name), 'w') as f:
        f.write(string)


@click.group()
def group():
    pass


@group.command()
def builder():
    write('Builder.java', render_template('Builder.java'))
